package mytest.versioncontrol.demo2.configuration;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    //路径中版本的前缀，这里用/v[1-9]/的形式
    private static final Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)");
    private int version;

    private int getVersion() {
        return version;
    }

    ApiVersionCondition(int version) {
        this.version = version;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(this.version);
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher matcher = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (matcher.find()) {
            int version = Integer.parseInt(matcher.group(1));
            if (version >= this.getVersion()) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getVersion() - this.version;
    }
}