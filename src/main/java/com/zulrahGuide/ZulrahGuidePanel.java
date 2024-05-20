package com.zulrahGuide;

import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ZulrahGuidePanel extends PluginPanel {

    @Inject
    ZulrahGuidePanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(10, 5, 10, 5));

        JLabel title = new JLabel();
        title.setText("Zulrah Guide");
        title.setForeground(Color.WHITE);

        topPanel.add(title, BorderLayout.NORTH);

        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBackground(Color.DARK_GRAY);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);

        final BufferedImage icon = ImageUtil.loadImageResource(ZulrahGuidePanel.class, "/zulrah_turq.png");
    }
}
