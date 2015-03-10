/*
 * Copyright 2012-2014 Sergey Ignatov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.erlang.context;

import com.intellij.openapi.project.Project;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.xmlb.annotations.Tag;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ErlangCompileContext implements Serializable {
  @Tag("name")
  private String myName;
  @Tag("macroDefinitions")
  private Map<String, String> myMacroDefinitions;
  @Tag("includePath")
  private List<String> myIncludePaths;
  //TODO add code path specification here (-pa and -pz compiler options)
  //TODO add other compiler options

  private transient Project myProject;

  // serialization
  @SuppressWarnings("UnusedDeclaration")
  public ErlangCompileContext() {
  }

  public ErlangCompileContext(String name) {
    this(null, name, Collections.<String, String>emptyMap(), ContainerUtil.<String>emptyList());
  }

  public ErlangCompileContext(@Nullable Project project, String name, Map<String, String> macroDefinitions, List<String> includePaths) {
    myProject = project;
    myName = name;
    myMacroDefinitions = macroDefinitions;
    myIncludePaths = includePaths;
  }

  public String getName() {
    return myName;
  }

  public void setName(String name) {
    myName = name;
  }

  public Map<String, String> getMacroDefinitions() {
    return myMacroDefinitions;
  }

  public void setMacroDefinitions(Map<String, String> macroDefinitions) {
    myMacroDefinitions = macroDefinitions;
  }

  public List<String> getIncludePaths() {
    return myIncludePaths;
  }

  public void setIncludePaths(List<String> includePaths) {
    myIncludePaths = includePaths;
  }

  @Nullable
  public Project getProject() {
    return myProject;
  }

  public void setProject(@Nullable Project project) {
    myProject = project;
  }
}