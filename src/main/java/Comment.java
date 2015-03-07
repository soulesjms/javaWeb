/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jonny
 */
public class Comment {
    private String content;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment(String content) {
        this.content = content;
    }
    public Comment() {
        content = "no comment";
    }
    @Override
    public String toString() {
        return content;
    }
}
