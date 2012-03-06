// net.vtst.ow.eclipse.less: An Eclipse module for LESS (http://lesscss.org)
// (c) Vincent Simonet, 2011.  All rights reserved.

package net.vtst.ow.eclipse.less;

import net.vtst.eclipse.easyxtext.guice.EasyXtextModule;
import net.vtst.ow.eclipse.less.resource.LessLocationInFileProvider;
import net.vtst.ow.eclipse.less.scoping.LessQualifiedNameProvider;

import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class LessRuntimeModule extends net.vtst.ow.eclipse.less.AbstractLessRuntimeModule {
  public static String PLUGIN_ID = "net.vtst.ow.eclipse.less";
  public static String CONTENT_TYPE_ID = "net.vtst.ow.eclipse.less";
  
  public LessRuntimeModule() {
    CssProfile.initializeRegistry();
  }
    
  public void configure(Binder binder) {
    super.configure(binder);
    binder.install(new EasyXtextModule());
  }
  
  public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
    return LessQualifiedNameProvider.class;
  }
  
  public Class<? extends ILinkingDiagnosticMessageProvider.Extended> bindILinkingDiagnosticMessageProvider() {
    return net.vtst.ow.eclipse.less.scoping.LessLinkingDiagnosticMessageProvider.class;
  }
  
  public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
    return LessLocationInFileProvider.class;
  }

}