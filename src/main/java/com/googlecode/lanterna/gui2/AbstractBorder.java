/*
 * This file is part of lanterna (http://code.google.com/p/lanterna/).
 * 
 * lanterna is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (C) 2010-2015 Martin
 */
package com.googlecode.lanterna.gui2;


import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;

/**
 *
 * @author Martin
 */
public abstract class AbstractBorder extends AbstractComposite<Border> implements Border {
    @Override
    public void setComponent(Component component) {
        super.setComponent(component);
        if(component != null) {
            component.setPosition(getWrappedComponentTopLeftOffset());
        }
    }

    @Override
    public BorderRenderer getRenderer() {
        return (BorderRenderer)super.getRenderer();
    }

    @Override
    public Border setSize(TerminalSize size) {
        super.setSize(size);
        getComponent().setSize(getWrappedComponentSize(size));
        return self();
    }

    @Override
    public LayoutData getLayoutData() {
        return getComponent().getLayoutData();
    }

    @Override
    public Border setLayoutData(LayoutData ld) {
        getComponent().setLayoutData(ld);
        return this;
    }

    private TerminalPosition getWrappedComponentTopLeftOffset() {
        return getRenderer().getWrappedComponentTopLeftOffset();
    }

    private TerminalSize getWrappedComponentSize(TerminalSize borderSize) {
        return getRenderer().getWrappedComponentSize(borderSize);
    }
}
