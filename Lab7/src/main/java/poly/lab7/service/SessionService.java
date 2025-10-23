package poly.lab7.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    /**
     * Ghi nhớ giá trị vào session
     * @param name Tên thuộc tính
     * @param value Giá trị
     */
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    /**
     * Đọc giá trị từ session
     * @param name Tên thuộc tính
     * @param defaultValue Giá trị mặc định nếu không tồn tại
     * @return Giá trị đọc được hoặc defaultValue
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        T value = (T) session.getAttribute(name);
        return value != null ? value : defaultValue;
    }

    /**
     * Xóa thuộc tính khỏi session
     * @param name Tên thuộc tính cần xóa
     */
    public void remove(String name) {
        session.removeAttribute(name);
    }
}