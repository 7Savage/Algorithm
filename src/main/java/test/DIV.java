package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DIV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getResultsFromHtml(s).size());
    }

    private static Pattern HTML_TAG_PATTERN = Pattern.compile("<div>([\\s\\S]*?)</div>");

    public static List<String> getResultsFromHtml(String htmlString) {
        List<String> results = new ArrayList<>();

        if (htmlString != null && htmlString.length() > 0) {
            Matcher imageTagMatcher = HTML_TAG_PATTERN.matcher(htmlString);
            // 针对多个并列的标签的情况
            while (imageTagMatcher.find()) {
                String result = "";
                // group(1)对应正则表达式中的圆括号括起来的数据
                result = imageTagMatcher.group(1).trim();

                // 针对多个标签嵌套的情况进行处理
                if (result != null && result.length() > 0) {
                    result = replaceStartTag(result);
                }

                results.add(result);
            }
        }
        return results;
    }


    public static String replaceStartTag(String content) {
        if (content == null || content.length() == 0) {
            return content;
        }
        String regEx = "<div>([\\s\\S]*?)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        if (m.find()) {
            content = m.replaceAll("");
        }
        return content;
    }

}
