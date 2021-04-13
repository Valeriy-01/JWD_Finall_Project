package by.tc.finalproject.controller.util.jsp;

import java.io.IOException;
import java.util.Formatter;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import by.tc.finalproject.dao.pool.ConnectionPool;

public class CopyrightTag extends TagSupport {
	private final static Logger log = Logger.getLogger(ConnectionPool.class);
	private static final long serialVersionUID = 1L;

	private static final String COPYRIGHT_DEFAULT = "Copyright &copy;. All rights reserved";
	private static final String COPYRIGHT_YEAR = "Copyright &copy;. All rights reserved %d";
	private static final String COPYRIGHT_OWNER = "Copyright &copy; by %s. <br> All rights reserved";
	private static final String COPYRIGHT_FULL = "Copyright &copy; by %s. <br> All rights reserved %d";

	private static final String P_TAG_START = "<p>";
	private static final String P_TAG_END = "</p>";

	private String owner;
	private Integer year;

	@Override
	public int doStartTag() throws JspTagException {
		Formatter formatter = null;
		try {
			JspWriter out = pageContext.getOut();
			out.write(P_TAG_START);
			formatter = new Formatter();
			out.write(createMessage(formatter));
		} catch (IOException e) {
			log.error("Can`t write start tag", e);
			throw new JspTagException(e);
		} finally {
			if (formatter != null) {
				formatter.close();
			}
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspTagException {
		try {
			pageContext.getOut().write(P_TAG_END);
		} catch (IOException e) {
			log.error("Can`t write end tag", e);
			throw new JspTagException(e);
		}
		return EVAL_PAGE;
	}

	private String createMessage(Formatter formatter) {

		if (owner != null && year != null) {
			return formatter.format(COPYRIGHT_FULL, owner, year).toString();
		}

		if (owner != null && year == null) {
			return formatter.format(COPYRIGHT_OWNER, owner).toString();
		}

		if (owner == null && year != null) {
			return formatter.format(COPYRIGHT_YEAR, year).toString();
		}

		return COPYRIGHT_DEFAULT;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
