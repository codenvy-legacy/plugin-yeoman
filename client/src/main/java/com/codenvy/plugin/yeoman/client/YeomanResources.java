/*******************************************************************************
 * Copyright (c) 2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.plugin.yeoman.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * @author Florent Benoit
 */
public interface YeomanResources extends ClientBundle {

    @ClientBundle.Source({"com/codenvy/plugin/yeoman/client/ui.css", "com/codenvy/ide/api/ui/style.css"})
    UiStyle uiCss();


    @Source("com/codenvy/plugin/yeoman/client/svg/trash.svg")
    SVGResource trashIcon();


    public interface UiStyle extends CssResource {

        @ClassName("yeoman-wizard-generateButton")
        String yeomanWizardGenerateButton();

        @ClassName("yeoman-wizard-generateButton-icon")
        String yeomanWizardGenerateButtonIcon();

        @ClassName("foldingPanel")
        String foldingPanel();

    }

}
