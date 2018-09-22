package application;


import application.entities.Stats;
import application.repo.StatsRepository;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class StatsTracker implements Filter {
    @Autowired
    StatsRepository statsRepository;


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        chain.doFilter(request, response);
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        UserAgent userAgent = UserAgent.parseUserAgentString(servletRequest.getHeader("User-Agent"));

        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        Browser browser = userAgent.getBrowser();

        DeviceType deviceType = userAgent.getOperatingSystem().getDeviceType();

        System.out.print(operatingSystem);
        System.out.print(browser);
        System.out.println(deviceType);

        Stats stats = new Stats();
        stats.setOperatingSystem(operatingSystem);
        stats.setBrowser(browser);
        stats.setDeviceType(deviceType);


        statsRepository.save(stats);

    }

    @Override
    public void destroy() {

    }
}
