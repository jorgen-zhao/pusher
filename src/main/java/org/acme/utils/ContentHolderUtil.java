package org.acme.utils;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.jboss.logging.Logger;
import org.springframework.util.PropertyPlaceholderHelper;
import java.text.MessageFormat;
import java.util.Map;

@RegisterForReflection // Required for runtime reflection
public class ContentHolderUtil {

    private static final Logger LOGGER = Logger.getLogger(ContentHolderUtil.class);

    /**
     * Placeholder prefix
     */
    private static final String PLACEHOLDER_PREFIX = "{$";

    /**
     * Placeholder suffix
     */
    private static final String PLACEHOLDER_SUFFIX = "}";

    private static final PropertyPlaceholderHelper PROPERTY_PLACEHOLDER_HELPER = new PropertyPlaceholderHelper(
            PLACEHOLDER_PREFIX, PLACEHOLDER_SUFFIX);

    public static String replacePlaceHolder(final String template, final Map<String, String> paramMap) {
        try {
            String replacedTemplate = PROPERTY_PLACEHOLDER_HELPER.replacePlaceholders(template,
                    new CustomPlaceholderResolver(template, paramMap));
            return replacedTemplate;
        } catch (IllegalArgumentException e) {
            LOGGER.errorf(e, "Failed to replace placeholders in template: %s with params: %s", template, paramMap);
            throw e;
        }
    }

    private static class CustomPlaceholderResolver implements PropertyPlaceholderHelper.PlaceholderResolver {
        private final String template;
        private final Map<String, String> paramMap;

        public CustomPlaceholderResolver(String template, Map<String, String> paramMap) {
            this.template = template;
            this.paramMap = paramMap;
        }

        @Override
        public String resolvePlaceholder(String placeholderName) {
            String value = paramMap.get(placeholderName);
            if (value == null) {
                String errorStr = MessageFormat.format("Template {0} requires parameter {1}, but it does not exist. Parameter map: {2}",
                        template, placeholderName, paramMap.toString());
                throw new IllegalArgumentException(errorStr);
            }
            return value;
        }
    }
}

