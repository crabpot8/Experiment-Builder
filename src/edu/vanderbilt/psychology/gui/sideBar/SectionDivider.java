/**
 * 
 */
package edu.vanderbilt.psychology.gui.sideBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

import javax.swing.JPanel;

/**
 * @author Hamilton Turner
 */
public class SectionDivider extends JPanel {
	private String text_;
	private Font font;
	private static final int PREFERRED_HEIGHT = 30;

	private static final int OFFSET = 30;

	public SectionDivider(String text) {
		super();
		text_ = text;
		font = new Font(Font.SERIF, Font.BOLD, 14);
		setPreferredSize(new Dimension(1, PREFERRED_HEIGHT));
		setMaximumSize(new Dimension(Short.MAX_VALUE, PREFERRED_HEIGHT));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int h = getHeight();
		int w = getWidth();

		Color color1 = getBackground();
		Color color2 = color1.darker().darker();

		// Paint a gradient from top to bottom
		GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);

		g2.setPaint(gp);
		g2.fillRect(0, 0, w, h);

		g2.setFont(font);
		g2.setPaint(Color.BLACK);
		FontRenderContext frc = g2.getFontRenderContext();
		LineMetrics lm = font.getLineMetrics(text_, frc);
		float height = lm.getAscent() + lm.getDescent();
		float x = OFFSET;
		float y = (h + height) / 2 - lm.getDescent();
		g2.drawString(text_, x, y);

		setOpaque(true);
	}

	/** Provide a Universal ID for serialization */
	private static final long serialVersionUID = 4019493616706873287L;

}