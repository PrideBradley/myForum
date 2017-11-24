package forum.service;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandlerServiceImpl implements FileHandlerService {

    private static FileHandlerService fileHandlerService;
    private static final String IMAGE_ROOT = "src/main/webapp/WEB-INF/image/";

    private FileHandlerServiceImpl() {}

    public static FileHandlerServiceImpl instance() {
        if (fileHandlerService == null)
            fileHandlerService = new FileHandlerServiceImpl();
        return (FileHandlerServiceImpl) fileHandlerService;
    }

    public BufferedImage getBufferedImage(String imageName, String extension) {
        BufferedImage bufImg = null;
        try {
            StringBuilder path = new StringBuilder(IMAGE_ROOT)
                    .append(imageName)
                    .append('.')
                    .append(extension);

            Image image = ImageIO.read(new File(path.toString()));
            bufImg = new BufferedImage(100 , 125,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(image, 0, 0, 100, 125, null);
            g.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufImg;
    }

    public void saveImage(long imageId, String extension, MultipartFile data) {
        StringBuilder stringBuilder = new StringBuilder(IMAGE_ROOT)
                .append(imageId)
                .append('.')
                .append(extension);

        File file = new File(stringBuilder.toString());
        try(BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file))) {
            byte[] bytes = data.getBytes();
            file.createNewFile();
            stream.write(bytes);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
