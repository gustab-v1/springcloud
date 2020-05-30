package com.leyou.upload.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UploadService {
    private static final List<String> ALLOW_TYPES = Arrays.asList("image/jpeg","image/png","image/bmp");
    public String uploadImage(MultipartFile file) {
        try {
            String contentType = file.getContentType();
            if(!ALLOW_TYPES.contains(contentType)){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image == null){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            File desc = new File("D:\\BaiduNetdiskDownload\\leyou-manage-web\\upload",file.getOriginalFilename());
            file.transferTo(desc);
            return "D:\\BaiduNetdiskDownload\\leyou-manage-web\\upload\\"+file.getOriginalFilename();
        } catch (IOException e) {
            log.error("上传文件失败",e);
            throw new LyException(ExceptionEnum.UPLOAD_ERROR);
        }
    }
}
