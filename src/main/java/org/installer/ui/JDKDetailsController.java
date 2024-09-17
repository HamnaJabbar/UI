package org.installer.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JDKDetailsController {

    @FXML
    private ImageView infoImageView;

    @FXML
    private Hyperlink downloadJDKLink;

    @FXML
    public void initialize() {
        // Handle ImageView click to open the WebView window
        infoImageView.setOnMouseClicked(event -> openWebViewWindow());

        // Handle Hyperlink click to open the JDK download page
        downloadJDKLink.setOnAction(event -> openJDKDownloadPage());
    }

    private void openWebViewWindow() {
        try {
            // Load the FXML for the WebView window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/installer/ui/web-view.fxml"));
            Parent root = loader.load();

            // Get the controller and set the URL

            WebViewWindowController controller = loader.getController();
            controller.loadUrl("https://www.youtube.com/watch?v=buECPGQlvV0");

            // Create and configure the WebView window
            Stage stage = new Stage();
            stage.setTitle("WebView Window");
            stage.setScene(new Scene(root, 800, 600)); // Set window size
            stage.show();

        } catch (IOException e) {
            // Handle any IOExceptions that occur during loading
            e.printStackTrace();
        }
    }

    private void openJDKDownloadPage() {
        try {
            // Define the JDK download URL
            String url = "https://www.oracle.com/java/technologies/javase-jdk11-downloads.html";

            // Open the URL in the default system browser
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (IOException | URISyntaxException e) {
            // Handle any exceptions that occur
            e.printStackTrace();
        }
    }
}
