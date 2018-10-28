package application.services;


import application.entities.Stats;
import application.repo.StatsRepository;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Service
public class StatsTracker implements Filter {
    @Autowired
    StatsRepository statsRepository;


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        UserAgent userAgent = UserAgent.parseUserAgentString(servletRequest.getHeader("User-Agent"));

        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        Browser browser = userAgent.getBrowser();

        DeviceType deviceType = userAgent.getOperatingSystem().getDeviceType();


        Stats stats = new Stats();
        stats.setOperatingSystem(operatingSystem.toString());
        stats.setBrowser(browser.toString());
        stats.setDeviceType(deviceType.toString());

        System.out.println(stats);

        statsRepository.save(stats);

    }

    @Override
    public void destroy() {

    }
}
