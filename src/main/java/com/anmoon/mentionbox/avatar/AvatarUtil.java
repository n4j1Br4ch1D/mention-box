package com.anmoon.mentionbox.avatar;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

@Component
public class AvatarUtil {

    public byte[] generateAvatar(String firstName, String lastName, int size, Color backgroundColor, String font) {
        String text = determineText(firstName, lastName);
        BufferedImage image = createAvatarImage(text, size, backgroundColor, font);
        return convertImageToByteArray(image);
    }

    public byte[] generateAvatar(String firstName, String lastName, int size, Color backgroundColor) {
        return generateAvatar(firstName, lastName, size, backgroundColor, "Arial");
    }

    public byte[] generateAvatar(String firstName, String lastName, int size) {
        return generateAvatar(firstName, lastName, size, null, "Arial");
    }

    private String determineText(String firstName, String lastName) {
            if (lastName != null && !lastName.isEmpty()) {
                return firstName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase();
            }
            return firstName.substring(0, 1).toUpperCase();
    }

    private BufferedImage createAvatarImage(String text, int size, Color backgroundColor, String font) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        Color finalBackgroundColor = (backgroundColor != null) ? backgroundColor : getRandomColor();
        graphics.setColor(finalBackgroundColor);
        graphics.fillRect(0, 0, size, size);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font(font, Font.BOLD, size / 2));
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int x = (size - fontMetrics.stringWidth(text)) / 2;
        int y = (size - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        graphics.drawString(text, x, y);

        graphics.dispose();

        return image;
    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private byte[] convertImageToByteArray(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            // Handle exception
        }
        return baos.toByteArray();
    }
}
