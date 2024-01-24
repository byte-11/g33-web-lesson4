package uz.pdp.g33weblesson4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;

import static uz.pdp.g33weblesson4.servlet.FilesServlet.BASE_FILES_PATH;

public class FilesDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String fileName = req.getParameter("file_name");
        if (fileName != null && !fileName.isBlank()) {
            byte[] bytes = Files.readAllBytes(BASE_FILES_PATH.resolve(fileName));
//            resp.addHeader("Content-Type", "application/octet-stream"); //For all files types
            resp.addHeader("Content-Type", URLConnection.guessContentTypeFromName(fileName)); // for a specific file type
            resp.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            resp.getOutputStream().write(bytes);
        } else {
            req.getRequestDispatcher("/files_download.jsp").forward(req, resp);
        }
    }
}
