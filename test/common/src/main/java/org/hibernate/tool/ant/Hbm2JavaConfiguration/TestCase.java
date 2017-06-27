package org.hibernate.tool.ant.Hbm2JavaConfiguration;

import java.io.File;

import org.hibernate.tools.test.util.AntUtil;
import org.hibernate.tools.test.util.FileUtil;
import org.hibernate.tools.test.util.JdbcUtil;
import org.hibernate.tools.test.util.ResourceUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestCase {
	
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	private File destinationDir = null;
	private File resourcesDir = null;
	
	@Before
	public void setUp() {
		destinationDir = new File(temporaryFolder.getRoot(), "destination");
		destinationDir.mkdir();
		resourcesDir = new File(temporaryFolder.getRoot(), "resources");
		resourcesDir.mkdir();
		JdbcUtil.createDatabase(this);
	}
	
	@After
	public void tearDown() {
		JdbcUtil.dropDatabase(this);
	}
	
	@Test
	public void testHbm2JavaConfiguration() {

		String resourcesLocation = ResourceUtil.getResourcesLocation(this);
		String[] resources = new String[] {"build.xml", "SomeClass.hbm.xml"};
		ResourceUtil.createResources(this, resourcesLocation, resources, resourcesDir);
		File buildFile = new File(resourcesDir, "build.xml");	
		ResourceUtil.createResources(this,  null, new String[] { "/hibernate.properties" }, resourcesDir);
		
		AntUtil.Project project = AntUtil.createProject(buildFile);
		project.setProperty("destinationDir", destinationDir.getAbsolutePath());
		project.setProperty("resourcesDir", resourcesDir.getAbsolutePath());
		
		File someClass = new File(destinationDir, "SomeClass.java");
		Assert.assertFalse(someClass.exists());
		
		project.executeTarget("testHbm2JavaConfiguration");
		
		Assert.assertTrue(someClass.exists());
		Assert.assertTrue(FileUtil
				.findFirstString("SomeClass", someClass)
				.contains("SomeClass generated by hbm2java"));
		Assert.assertNull(FileUtil.findFirstString("@Entity", someClass));
		
	}
	
}
