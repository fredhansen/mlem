package application.config;

import application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

public class UserInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserService userService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            Principal principal = request.getUserPrincipal();
            if (principal != null) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    modelAndView.addObject("user", userService.getUser(principal));
                }
            }
        }
    }
}