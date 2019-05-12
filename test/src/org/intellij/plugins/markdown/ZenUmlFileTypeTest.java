package org.intellij.plugins.markdown;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.PlatformTestCase;
import org.intellij.plugins.markdown.lang.ZenUmlFileType;
import org.intellij.plugins.markdown.lang.psi.impl.ZenUmlFile;

import java.io.File;
import java.io.IOException;

public class ZenUmlFileTypeTest extends PlatformTestCase {
  public void testMarkdownExtension() throws IOException {
    doTest(".markdown");
  }

  public void testMdExtension() throws IOException {
    doTest(".md");
  }

  private void doTest(String extension) throws IOException {
    File dir = createTempDirectory();
    File file = FileUtil.createTempFile(dir, "test", extension, true);
    VirtualFile virtualFile = getVirtualFile(file);
    assertNotNull(virtualFile);
    PsiFile psi = getPsiManager().findFile(virtualFile);
    assertTrue(psi instanceof ZenUmlFile);
    assertEquals(ZenUmlFileType.INSTANCE, virtualFile.getFileType());
  }
}
