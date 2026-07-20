/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pnhp.utils;

import com.pnhp.libraryapp.App;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Phupham
 */
public class MyStageSingleton {
    private static MyStageSingleton instance;
    private final Stage stage;
    
    private MyStageSingleton(){
        this.stage=new Stage();
        this.stage.setTitle("Library App");
    }
    
    public static MyStageSingleton getInstance(){
        if(instance == null)
            instance = new MyStageSingleton();
        return instance;
    }
    
    public FXMLLoader showStage(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
            Scene scene = new Scene(loader.load());

            this.stage.setScene(scene);
            
            // Nếu stage chưa hiển thị thì bật lên
            if (!this.stage.isShowing()) {
                this.stage.show();
            }
            
            // QUAN TRỌNG: Trả về loader để các Controller có thể truyền dữ liệu cho nhau
            return loader; 
            
        } catch (IOException ex) {
            ex.printStackTrace(); // In ra lỗi nếu không tìm thấy file fxml
            return null;
        }
    }
}