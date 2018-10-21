package application.entities;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {

    private MultipartFile file;

    public UploadForm(MultipartFile file) {
        this.file = file;
    }

    public UploadForm() {
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
