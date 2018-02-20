import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;
 
mavenName = "MVN 3.5"
mavenVersion = "3.5.2"
 
// Grab the Maven "task" (which is the plugin handle).
mavenPlugin = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0]
 
// Add an installation.
newMavenInstall = new hudson.tasks.Maven.MavenInstallation('maven-3', null,
    [new hudson.tools.InstallSourceProperty([new hudson.tasks.Maven.MavenInstaller(mavenVersion)])]
)

mavenPlugin.installations += newMavenInstall
mavenPlugin.save()
