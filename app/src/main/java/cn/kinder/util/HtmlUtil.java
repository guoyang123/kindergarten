package cn.kinder.util;

public class HtmlUtil {

	 /**
		 * 创建html
		 */
		public static  String creatHtml(String content) {
			String showHtml="";
			showHtml += "<!DOCTYPE HTML>";
			showHtml += "<html>";
			showHtml += "<head>";
			showHtml += "<meta charset=\"utf-8\"/>";
			showHtml += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"/>";
			showHtml += "<meta content=\"telephone=no\" name=\"format-detection\" />";
			showHtml += "<style type=\"text/css\">";
			showHtml += "body { background-color: #ffffff; }";
			showHtml += ".main { min-width: 280px; margin-left:8px; margin-right: 8px;  }";
			showHtml += ".text { TEXT-INDENT: 2em; line-height: 25px; text-align: justify; }";
			showHtml += ".title { font-weight: bold; margin-top: 30px; margin-bottom: 10px; }";
			showHtml += ".src { font-weight: bold; color: #aaaaaa; }";
			showHtml += ".fontSize1 .title { font-size:20px; }";
			showHtml += ".fontSize1 .text { font-size:15px; }";
			showHtml += ".fontSize1 .src { font-size:11px; }";
			showHtml += ".fontSize2 .title { font-size:22px; }";
			showHtml += ".fontSize2 .text { font-size:17px; }";
			showHtml += ".fontSize2 .src { font-size:13px; }";
			showHtml += ".fontSize3 .title { font-size:24px; }";
			showHtml += ".fontSize3 .text { font-size:19px; }";
			showHtml += ".fontSize3 .src { font-size:15px; }";
			showHtml += ".fontSize4 .title { font-size:26px; }";
			showHtml += ".fontSize4 .text { font-size:21px; }";
			showHtml += ".fontSize4 .src { font-size:16px; }";
			showHtml += "</style>";
			showHtml += "</head>";
			showHtml += "<body>";
			showHtml += "<div id=\"content\" class=\"main fontSize2\">";
			showHtml += "<p class=\"text\">";
			
			//内容
			showHtml += content;
			
			showHtml += "</p>";
			showHtml += "</div>";
			showHtml += "</body>";
			showHtml += "</html>";
			return showHtml;
		}
}
