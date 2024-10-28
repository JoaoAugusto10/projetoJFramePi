/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.lookandfeel;

import java.awt.Color;
import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author kaik.salves
 */
public class DefaultLookAndFeel extends MetalLookAndFeel{
    
     @Override
    public String getName() {
        return "DefaultLookAndFeel";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    @Override
    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);
        
        // Definindo cores personalizadas
        // Personalizando outros componentes
        table.put("Panel.background", new ColorUIResource(new Color(0xDBCDC2)));
    }
}
