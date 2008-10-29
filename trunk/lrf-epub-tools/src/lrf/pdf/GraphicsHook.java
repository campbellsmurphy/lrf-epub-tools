package lrf.pdf;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class GraphicsHook extends Graphics2D {
	private ByteArrayOutputStream baos=new ByteArrayOutputStream();
	private PrintWriter pw=new PrintWriter(baos);
	
	public void p(String s, int... v){
		pw.print(s);
		for(int i=0;i<v.length;i++)
			pw.print(" "+v[i]);
		pw.print("\n");
	}

	public void q(String s, double... v){
		pw.print(s);
		for(int i=0;i<v.length;i++)
			pw.print(" "+v[i]);
		pw.print("\n");
	}

	@Override
	public void clearRect(int x, int y, int width, int height) {
		p("clearRect",x,y,width,height);
	}

	@Override
	public void clipRect(int x, int y, int width, int height) {
		p("clipRect",x,y,width,height);
	}

	@Override
	public void copyArea(int x, int y, int width, int height, int dx, int dy) {
		p("copyArea",x,y,width,height,dx,dy);
	}

	@Override
	public Graphics create() {
		p("create");
		return null;
	}

	@Override
	public void dispose() {
		p("dispose");
	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		p("drawArc",x,y,width,height,startAngle,arcAngle);
	}

	@Override
	public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
		p("drawImage-ImageObserver",x,y);
		return true;
	}

	@Override
	public boolean drawImage(Image img, int x, int y, Color bgcolor,
			ImageObserver observer) {
		p("drawImage-bgColor-ImageObserver",x,y);
		return true;
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height,
			ImageObserver observer) {
		p("drawImage-ImageObserver",x,y,width,height);
		return true;
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height,
			Color bgcolor, ImageObserver observer) {
		p("drawImage-bgColor-ImageObserver",x,y,width,height);
		return true;
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
			int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
		p("drawImage-ImageObserver",dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2);
		return true;
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
			int sx1, int sy1, int sx2, int sy2, Color bgcolor,
			ImageObserver observer) {
		p("drawImage-bgColor-ImageObserver",dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2);
		return true;
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		p("drawLine",x1,y1,x2,y2);
	}

	@Override
	public void drawOval(int x, int y, int width, int height) {
		p("drawOval",x,y,width,height);
	}

	@Override
	public void drawPolygon(int[] points, int[] points2, int points3) {
		p("drawPoly-x",points);
		p("drawPoly-y",points2);
		p("drawPoly-n",points3);
	}

	@Override
	public void drawPolyline(int[] points, int[] points2, int points3) {
		p("drawPolyline-x",points);
		p("drawPolyline-y",points2);
		p("drawPolyline-n",points3);
	}

	@Override
	public void drawRoundRect(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		p("drawRoundRect",x,y,width,height,arcWidth,arcHeight);
	}

	@Override
	public void drawString(String str, int x, int y) {
		p("drawString "+str,x,y);
	}

	@Override
	public void drawString(AttributedCharacterIterator iterator, int x, int y) {
		p("drawString-iterator",x,y);
		// TODO Auto-generated method stub
	}

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		p("fillArc",x,y,width,height,startAngle,arcAngle);

	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		p("fillOval",x,y,width,height);
	}

	@Override
	public void fillPolygon(int[] points, int[] points2, int points3) {
		p("fillPolygon-x",points);
		p("fillPolygon-y",points2);
		p("fillPolygon-n",points3);

	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		p("fillRect",x,y,width,height);
	}

	@Override
	public void fillRoundRect(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		p("fillRoundRect",x,y,width,height,arcWidth,arcHeight);
	}

	@Override
	public Shape getClip() {
		p("getClip");
		return _clip;
	}

	@Override
	public Rectangle getClipBounds() {
		p("getClipBounds");
		return null;
	}

	@Override
	public Color getColor() {
		p("getColor");
		return null;
	}

	@Override
	public Font getFont() {
		p("getFont");
		return _font;
	}

	@Override
	public FontMetrics getFontMetrics(Font f) {
		p("getFontMetrics-"+f.getFamily()+"-"+f.getFontName());
		return null;
	}

	Shape _clip=null;
	@Override
	public void setClip(Shape clip) {
		_clip=clip;
		p("seClip-"+clip.toString());
	}

	@Override
	public void setClip(int x, int y, int width, int height) {
		p("setClip",x,y,width,height);
	}

	@Override
	public void setColor(Color c) {
		p("setColor",c.getRGB());
	}

	Font _font=null;
	@Override
	public void setFont(Font f) {
		_font=f;
		p("setFont-"+f.getFamily()+"-"+f.getFontName());
	}

	@Override
	public void setPaintMode() {
		p("setPaintMode");
	}

	@Override
	public void setXORMode(Color c1) {
		p("setXorMode",c1.getRGB());
	}

	@Override
	public void translate(int x, int y) {
		p("translate",x,y);
	}

	public String toString(){
		pw.close();
		return new String(baos.toByteArray());
	}
	@Override
	public void addRenderingHints(Map<?, ?> hints) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void clip(Shape s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(Shape s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawGlyphVector(GlyphVector g, float x, float y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawString(String str, float x, float y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawString(AttributedCharacterIterator iterator, float x,
			float y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void fill(Shape s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Color getBackground() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public GraphicsConfiguration getDeviceConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FontRenderContext getFontRenderContext() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Paint getPaint() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getRenderingHint(Key hintKey) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RenderingHints getRenderingHints() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Stroke getStroke() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AffineTransform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void rotate(double theta) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void rotate(double theta, double x, double y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void scale(double sx, double sy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setBackground(Color color) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setComposite(Composite comp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPaint(Paint paint) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setRenderingHint(Key hintKey, Object hintValue) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setRenderingHints(Map<?, ?> hints) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setStroke(Stroke s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setTransform(AffineTransform Tx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void shear(double shx, double shy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void transform(AffineTransform Tx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void translate(double tx, double ty) {
		// TODO Auto-generated method stub
		
	}
}
