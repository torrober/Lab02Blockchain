/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesUI.fx;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

/**
 * @author XDSSWAR
 * https://github.com/xdsswar/JavaFx-SliderShow-Background-Animation/blob/main/src/main/java/com/bg/sl/NiceSliderShow.java
 */
public class NiceSliderShow extends AnchorPane {
    /**
     * Variables/Constants
     */
    private static FadeTransition transition;
    private final StackPane stackPane =new StackPane();
    private final AnchorPane backPane=new AnchorPane();
    private final AnchorPane frontPane=new AnchorPane();
    private final ObservableList<Image> backImages= FXCollections.observableArrayList();
    private final ObservableList<Image> frontImages=FXCollections.observableArrayList();
    private int backIndex=0;
    private int frontIndex=0;

    /**
     * Constructor
     */
    public NiceSliderShow(){
        super();
        initialize();
    }

    /**
     * Initialize
     */
    private void initialize(){
        this.stackPane.getChildren().addAll(backPane, frontPane);
        frontPane.toFront();
        frontPane.setOpacity(0);
        backPane.toBack();
        AnchorUtil.setAnchor(stackPane,0.0,0.0,0.0,0.0);
        getChildren().add(stackPane);
    }

    /**
     * Set Images
     * @param images Array
     */
    public void setImages(Image... images){
        if (images.length<3){
            try {
                throw new Exception("The image quantity must be 3 or more!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            for (int i=0;i<images.length;i++){
                if (i%2==0){
                    frontImages.add(images[i]);
                }else {
                    backImages.add(images[i]);
                }
            }
        }
        setBackgroundImage(backPane,backImages.get(0));
        setBackgroundImage(frontPane,frontImages.get(0));

    }

    /**
     * Init the SliderShow
     * @param animationDelay animation delay
     * @param visibilityDelay visibility delay
     */
    public void initSliderShow(double animationDelay, int visibilityDelay){
        Runnable rn=()->{
            Platform.runLater(()->{
                frontPane.opacityProperty().addListener((observable, oldValue, newValue) -> {
                    PauseTransition pt;
                    if (newValue.doubleValue()==0){
                        frontIndex++;
                        if (frontIndex==frontImages.size()){
                            frontIndex=0;
                        }
                        setBackgroundImage(frontPane,frontImages.get(frontIndex));
                        pt=new PauseTransition(Duration.seconds(visibilityDelay));
                        pt.setOnFinished(event -> {
                          transition.play();
                        });
                        transition.pause();
                        pt.play();
                    }else if (newValue.doubleValue()==1){
                        backIndex++;
                        if (backIndex==backImages.size()){
                            backIndex=0;
                        }
                        setBackgroundImage(backPane,backImages.get(backIndex));
                        pt=new PauseTransition(Duration.seconds(visibilityDelay));
                        pt.setOnFinished(event -> {
                            transition.play();
                        });
                        transition.pause();
                        pt.play();
                    }
                });
            });

            transition=new FadeTransition(Duration.seconds(animationDelay),frontPane);
            transition.setFromValue(0);
            transition.setToValue(1);
            transition.setAutoReverse(true);
            transition.setCycleCount(-1);
            transition.play();

        };
        Thread t=new Thread(rn);
        t.start();
    }

    /**
     * Stop the Animation
     */
    public synchronized void stop(){
        if (transition!=null){
            transition.stop();
        }
    }


    /**
     * Set the Background Image
     * @param target AnchorPane target
     * @param image Image
     */
    private void setBackgroundImage(AnchorPane target, Image image){
        BackgroundSize backgroundSize=new BackgroundSize(100, 100,true, true,true, true);
        BackgroundImage backgroundImage=new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,backgroundSize);
        Background background=new Background(backgroundImage);
        target.setBackground(background);
    }
}
