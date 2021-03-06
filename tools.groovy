import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import hudson.tools.*

// Set up Maven.
mavenName = "MVN 3.5"
mavenVersion = "3.5.2"
 
// Grab the Maven "task" (which is the plugin handle).
mavenPlugin = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0]
 
// Add an installation.
newMavenInstall = new hudson.tasks.Maven.MavenInstallation(mavenName, null,
    [new hudson.tools.InstallSourceProperty([new hudson.tasks.Maven.MavenInstaller(mavenVersion)])]
)

mavenPlugin.installations += newMavenInstall
mavenPlugin.save()

// Set up JDK.
def jdkInstaller = new JDKInstaller('jdk-8u162-oth-JPR', true)
def jdkInstallerProps = new InstallSourceProperty([jdkInstaller])
def jdkInstallation = new JDK('JDK 8', "", [jdkInstallerProps])
def jdkInstallations = []
jdkInstallations.push(jdkInstallation)

def inst = Jenkins.getInstance()

def desc = inst.getDescriptor("hudson.model.JDK")
desc.setInstallations(jdkInstallations.toArray(new JDK[0]))

desc.save() 
