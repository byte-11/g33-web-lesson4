package uz.pdp.g33weblesson4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

//@WebServlet("/files")
@MultipartConfig //if it is not provided , you cannot get input file in your servlet
public class FilesServlet extends HttpServlet {

    public static final Path BASE_FILES_PATH = Path.of(System.getProperty("user.home"), "/Documents/g33/test");

    @Override
    public void init() throws ServletException {
        if (!Files.exists(BASE_FILES_PATH)) {
            try {
                Files.createDirectories(BASE_FILES_PATH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/files.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("u_file");
        String fileName = file.getSubmittedFileName();
        InputStream inputStream = file.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf('.'));
        Files.write(
                BASE_FILES_PATH.resolve(newFileName),
                bytes,
                StandardOpenOption.CREATE_NEW
        );
//        Files.copy(
//                inputStream,
//                BASE_FILES_PATH.resolve(file.getSubmittedFileName()),
//                StandardCopyOption.REPLACE_EXISTING
//        );
    }
}
