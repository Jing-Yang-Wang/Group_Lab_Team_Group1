/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.AdminRole.Dashboard;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author kal bugrara
 */
public class ChartPanel extends JPanel {
    
    private Map<String, Integer> data;
    private String chartType;
    private String title;
    
    public ChartPanel(Map<String, Integer> data, String chartType, String title) {
        this.data = data;
        this.chartType = chartType;
        this.title = title;
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.WHITE);
    }
    
    public void updateData(Map<String, Integer> newData) {
        this.data = newData;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (data == null || data.isEmpty()) {
            g2d.setColor(Color.BLACK);
            g2d.drawString("No data available", 50, 100);
            return;
        }
        
        if ("pie".equals(chartType)) {
            drawPieChart(g2d);
        } else if ("bar".equals(chartType)) {
            drawBarChart(g2d);
        }
        
      
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        FontMetrics fm = g2d.getFontMetrics();
        int titleWidth = fm.stringWidth(title);
        g2d.drawString(title, (getWidth() - titleWidth) / 2, 20);
    }
    
    private void drawPieChart(Graphics2D g2d) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2 ;
        int radius = Math.min(getWidth(), getHeight()) / 3;
        
        int total = data.values().stream().mapToInt(Integer::intValue).sum();
        if (total == 0) return;
        
        double startAngle = 0;
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN};
        int colorIndex = 0;
        
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            double angle = (entry.getValue() * 360.0) / total;
            
            g2d.setColor(colors[colorIndex % colors.length]);
            g2d.fill(new Arc2D.Double(centerX - radius, centerY - radius, 
                    radius * 2, radius * 2, startAngle, angle, Arc2D.PIE));
            
           
            double labelAngle = Math.toRadians(startAngle + angle / 2);
            int labelX = (int) (centerX + Math.cos(labelAngle) * (radius + 20));
            int labelY = (int) (centerY + Math.sin(labelAngle) * (radius + 20));
            
            g2d.setColor(Color.BLACK);
            g2d.drawString(entry.getKey() + ": " + entry.getValue(), labelX, labelY);
            
            startAngle += angle;
            colorIndex++;
        }
    }
    
    private void drawBarChart(Graphics2D g2d) {
        int barWidth = getWidth() / (data.size() + 1);
        int maxValue = data.values().stream().mapToInt(Integer::intValue).max().orElse(1);
        int chartHeight = getHeight() - 60;
        int startX = barWidth / 2;
        int startY = getHeight() - 40;
        
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN};
        int colorIndex = 0;
        
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            int barHeight = (int) ((entry.getValue() * chartHeight) / maxValue);
            
            g2d.setColor(colors[colorIndex % colors.length]);
            g2d.fillRect(startX, startY - barHeight, barWidth - 10, barHeight);
            
            g2d.setColor(Color.BLACK);
            g2d.drawRect(startX, startY - barHeight, barWidth - 10, barHeight);
            
           
            g2d.setFont(new Font("Arial", Font.PLAIN, 10));
            String label = entry.getKey() + ": " + entry.getValue();
            FontMetrics fm = g2d.getFontMetrics();
            int labelWidth = fm.stringWidth(label);
            g2d.drawString(label, startX + (barWidth - labelWidth) / 2, startY + 15);
            
            startX += barWidth;
            colorIndex++;
        }
    }
}
