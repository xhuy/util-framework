package util;

import javafx.scene.image.Image;

/**
 * Utility class that creates images for notifications (errors, icons, etc)
 * 
 * @author jesus.herrera
 *
 */
public class JavaFXImageUtil {

	public static final String IMAGE_PATH_ERROR = "/resources/notification_error.png";

	public static final String IMAGE_PATH_CORRECT = "/resources/notification_error.png";

	/**
	 * Create a <code>Image</code> object from a file in the specified path
	 * 
	 * @param mainClass
	 *            Main class from the JavaFX application
	 * @param path
	 *            path inside the application (Generally src/main/resources)
	 * @return <code>Image</code> object with the specified image in the path
	 */
	public static <T> Image createImageFromFile(Class<T> mainClass, String path) {
		return new Image(mainClass.getClass().getResourceAsStream(path));
	}

	/**
	 * Create a <code>Image</code> object from a file in the specified path,
	 * used for notification like validations
	 * 
	 * @param mainClass
	 *            Main class from the JavaFX application
	 * @return <code>Image</code> object with the image for Error Notification
	 */
	public static <T> Image createImageNotificationError(Class<T> mainClass) {
		return new Image(mainClass.getClass().getResourceAsStream(IMAGE_PATH_ERROR));
	}

	/**
	 * Create a <code>Image</code> object from a file in the specified path,
	 * used for notification like validations
	 * 
	 * @param mainClass
	 *            Main class from the JavaFX application
	 * @return <code>Image</code> object with the image for Correct Validation
	 */
	public static <T> Image createImageNotificationCorrect(Class<T> mainClass) {
		return new Image(mainClass.getClass().getResourceAsStream(IMAGE_PATH_CORRECT));
	}

}
