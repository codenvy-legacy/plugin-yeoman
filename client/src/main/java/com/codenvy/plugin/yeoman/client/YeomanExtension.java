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

import com.codenvy.api.project.shared.dto.ProjectDescriptor;
import com.codenvy.ide.api.event.ProjectActionEvent;
import com.codenvy.ide.api.event.ProjectActionHandler;
import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.parts.PartStackType;
import com.codenvy.ide.api.parts.WorkspaceAgent;
import com.codenvy.plugin.yeoman.client.panel.YeomanPartPresenter;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Extension registering Yeoman Panel
 * @author Florent Benoit
 */
@Singleton
@Extension(title = "Yeoman extension")
public class YeomanExtension {


    @Inject
    public YeomanExtension(final YeomanResources resources,
                           final WorkspaceAgent workspaceAgent,
                           final YeomanPartPresenter yeomanPartPresenter,
                           final EventBus eventBus) {
        // inject CSS
        resources.uiCss().ensureInjected();

        // Display Yeoman Panel with this extension
        eventBus.addHandler(ProjectActionEvent.TYPE, new ProjectActionHandler() {
            @Override
            public void onProjectOpened(ProjectActionEvent event) {

                ProjectDescriptor project = event.getProject();
                final String projectTypeId = project.getProjectTypeId();
                boolean isAngularJSProject = "AngularJS".equals(projectTypeId);
                if (isAngularJSProject) {
                    // add Yeoman panel
                    workspaceAgent.openPart(yeomanPartPresenter, PartStackType.TOOLING);
                    workspaceAgent.hidePart(yeomanPartPresenter);
                }
            }

            /**
             * Remove Yeoman panel when closing the project if this panel is displayed.
             * @param event the project event
             */
            @Override
            public void onProjectClosed(ProjectActionEvent event) {
                ProjectDescriptor project = event.getProject();
                final String projectTypeId = project.getProjectTypeId();
                boolean isAngularJSProject = "AngularJS".equals(projectTypeId);
                if (isAngularJSProject) {
                    workspaceAgent.removePart(yeomanPartPresenter);
                }

            }
        });

    }
}
