package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Image;
import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.dto.ImageDto;
import SongGyun.ShoppingMallProject.repository.ImageRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${image.dir}")
    private String imageDir;

    public String getFullPath(String imageName) {
        return imageDir + imageName;
    }


    //base64이미지를 디코딩해서 실제로 저장하고 Image객체로 바꾸어 저장
    public Image storeImage(ImageDto imageDto) throws IOException
    {
        log.info("ImageService : storeImage");
        String storeImageName = createStoreFileName(imageDto.getImageName());
        File image = new File(getFullPath(storeImageName));
        byte[] decodeBytes = Base64.getDecoder().decode(imageDto.getBase64Image().getBytes());
        FileOutputStream fos = new FileOutputStream(image);
        fos.write(decodeBytes);
        fos.close();

        return Image.builder().uploadImageName(imageDto.getImageName()).storeImageName(storeImageName).build();
    }

    //base64이미지를 인코딩해서 Image객체로 바꾸어 넘겨주기
    public List<ImageDto> readImage(Item item) throws IOException {
        log.info("ImageService : readImage");
        List<ImageDto> imageDtoList = new ArrayList<>();

        for (Image image : item.getImageList()) {
            File file = new File(getFullPath(image.getStoreImageName()));
            InputStream ins = new FileInputStream(file);
            String base64Image = Base64.getEncoder().encodeToString(StreamUtils.copyToByteArray(ins));
            imageDtoList.add(ImageDto.builder().base64Image(base64Image).imageName(image.getUploadImageName()).build());
        }

        return imageDtoList;
    }


    //서버 내부에서 관리하는 이미지명은 유일한 이름을 생성하는 UUID 를 사용해서 충돌하지 않도록 한다.
    private String createStoreFileName(String originalImageName) {
        //String ext = extractExt(originalImageName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + "png";
    }

    //확장자를 별도로 추출해서 서버 내부에서 관리하는 이미지명에도 붙여준다.
    private String extractExt(String originalImageName) {
        int pos = originalImageName.lastIndexOf(".");
        return originalImageName.substring(pos + 1);
    }


}
