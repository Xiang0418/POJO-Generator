package fr.jukien.intellij.plugins.ui;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created on 24/04/2019
 *
 * @author JDI
 * @version 1.0.0
 * @since 1.0.0
 */
public class POJOGeneratorConfigurable implements Configurable {
    private final POJOGeneratorSettings pojoGeneratorSettings;
    private POJOGeneratorConfigurableGUI pojoGeneratorConfigurableGUI;

    public POJOGeneratorConfigurable(Project project) {
        this.pojoGeneratorSettings = ServiceManager.getService(project, POJOGeneratorSettings.class);
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "POJO Generator";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (null == pojoGeneratorConfigurableGUI) {
            pojoGeneratorConfigurableGUI = new POJOGeneratorConfigurableGUI(pojoGeneratorSettings);
        }
        return pojoGeneratorConfigurableGUI.getCapitalizeTheNameOfCheckBox();
    }

    @Override
    public boolean isModified() {
        return pojoGeneratorConfigurableGUI.getCapitalizeTheNameOfCheckBox().isSelected() != pojoGeneratorSettings.getCapitalize();
    }

    @Override
    public void apply() throws ConfigurationException {
        pojoGeneratorSettings.setCapitalize(pojoGeneratorConfigurableGUI.getCapitalizeTheNameOfCheckBox().isSelected());
    }
}