/*
 * CODENVY CONFIDENTIAL
 *  __________________
 *
 *   [2014] Codenvy, S.A.
 *   All Rights Reserved.
 *
 *  NOTICE:  All information contained herein is, and remains
 *  the property of Codenvy S.A. and its suppliers,
 *  if any.  The intellectual and technical concepts contained
 *  herein are proprietary to Codenvy S.A.
 *  and its suppliers and may be covered by U.S. and Foreign Patents,
 *  patents in process, and are protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material
 *  is strictly forbidden unless prior written permission is obtained
 *  from Codenvy S.A..
 */

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
package com.codenvy.plugin.yeoman.client.inject;

import com.codenvy.ide.api.extension.ExtensionGinModule;
import com.codenvy.ide.ext.web.html.editor.AutoEditStrategyFactory;
import com.codenvy.ide.ext.web.html.editor.HTMLCodeAssistProcessor;
import com.codenvy.ide.ext.web.js.editor.JsCodeAssistProcessor;
import com.codenvy.plugin.yeoman.client.panel.FoldingPanel;
import com.codenvy.plugin.yeoman.client.panel.FoldingPanelFactory;
import com.codenvy.plugin.yeoman.client.panel.FoldingPanelImpl;
import com.codenvy.plugin.yeoman.client.panel.GeneratedItemView;
import com.codenvy.plugin.yeoman.client.panel.GeneratedItemViewFactory;
import com.codenvy.plugin.yeoman.client.panel.GeneratedItemViewImpl;
import com.codenvy.plugin.yeoman.client.panel.YeomanPartView;
import com.codenvy.plugin.yeoman.client.panel.YeomanPartViewImpl;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.inject.client.multibindings.GinMultibinder;
import com.google.inject.Singleton;

/**
 * Gin Module for injection performed in Yeoman
 * @author Florent Benoit
 */
@ExtensionGinModule
public class YeomanModule extends AbstractGinModule {

        /** {@inheritDoc} */
        @Override
        protected void configure() {
            // Add the yeoman panel and its sub elements
            bind(YeomanPartView.class).to(YeomanPartViewImpl.class).in(Singleton.class);
            install(new GinFactoryModuleBuilder().implement(FoldingPanel.class, FoldingPanelImpl.class)
                                                 .build(FoldingPanelFactory.class));
            install(new GinFactoryModuleBuilder().implement(GeneratedItemView.class, GeneratedItemViewImpl.class)
                                                 .build(GeneratedItemViewFactory.class));


        }

}
