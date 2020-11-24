package com.leyou.es.demo;

import com.leyou.es.pojo.Item;
import com.leyou.es.repository.ItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testCreate(){
        //创建索引库
        elasticsearchTemplate.createIndex(Item.class);
        //映射关系
        elasticsearchTemplate.putMapping(Item.class);
    }
    @Test
    public void insertIndex(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L,"小米手机6","手机","小米",3299.00,"image1"));
        itemList.add(new Item(2L,"坚果手机R1","手机","锤子",3699.00,"image2"));
        itemList.add(new Item(3L,"华为META10","手机","华为",4499.00,"image3"));
        itemRepository.saveAll(itemList);
    }
    @Test
    public void testFind(){
        Iterable<Item> items = itemRepository.findAll();
        for (Item item : items) {
            System.out.println("item="+item);
        }
    }
    @Test
    public void testFindBy(){
        List<Item> items = itemRepository.findByPriceBetween(3000.00, 4000.00);
        for (Item item : items) {
            System.out.println(item);
        }
    }
    @Test
    public void testQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //结果过滤
        nativeSearchQueryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{"title","price"},null));
        //添加查询条件
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("id", 2L));
        //排序
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        //分页
        nativeSearchQueryBuilder.withPageable(PageRequest.of(0,2));
        //MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "坚果手机");
        Page<Item> result = itemRepository.search(nativeSearchQueryBuilder.build());
        List<Item> items = result.getContent();
        System.out.println("total="+result.getTotalElements());
        System.out.println(items);
    }
    @Test
    public void testAgg(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        String aggName = "popularBrand";
        //聚合
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms(aggName).field("brand"));
        //查询并返回带聚合结果
        AggregatedPage<Item> items = elasticsearchTemplate.queryForPage(nativeSearchQueryBuilder.build(), Item.class);
        //解析聚合
        Aggregations aggregations = items.getAggregations();
        //获取指定名称的聚合
        StringTerms stringTerms = aggregations.get(aggName);
        //获取桶
        List<StringTerms.Bucket> buckets = stringTerms.getBuckets();
        for (StringTerms.Bucket bucket : buckets) {
            System.out.println("key:"+bucket.getKeyAsString());
            System.out.println("documentCount:"+bucket.getDocCount());
        }
    }
}
