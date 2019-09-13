package fr.jukien.intellij.plugins.ui;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.Iconable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created on 24/08/2019
 *
 * @author JDI
 * @version 2.0.0
 * @since 2.0.0
 */
public enum DBMSFamily implements Iconable {
    MYSQL("MySQL", AllIcons.Providers.Mysql, "varchar", "String", null),
    ORACLE("Oracle", AllIcons.Providers.Oracle, "VARCHAR2", "String", null),
    POSTGRES("PostgreSQL", AllIcons.Providers.Postgresql, "varchar", "String", null);

    private final String name;
    private final Icon icon;
    private final String sqlDataType;
    private final String javaDataType;
    private final String javaColumnDefinition;

    DBMSFamily(@NotNull String name,
               @NotNull Icon icon,
               @NotNull String sqlDataType,
               @NotNull String javaDataType,
               @Nullable String javaColumnDefinition) {
        this.name = name;
        this.icon = icon;
        this.sqlDataType = sqlDataType;
        this.javaDataType = javaDataType;
        this.javaColumnDefinition = javaColumnDefinition;
    }

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Icon getIcon(@IconFlags int flags) {
        return getIcon();
    }

    public String getSqlDataType() {
        return sqlDataType;
    }

    public String getJavaDataType() {
        return javaDataType;
    }

    public String getJavaColumnDefinition() {
        return javaColumnDefinition;
    }
}