/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;

/**
 *
 * @author Director
 */
public class TextEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextEditorGUI obj = new TextEditorGUI();
        obj.setBounds(0,0,700,700);
        obj.setTitle("Text Editor");
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(TextEditorGUI.EXIT_ON_CLOSE);
    }
    
}
