/**
 * Copyright 2008 the original author or authors.
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
package net.sf.katta.node;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;

import net.sf.katta.AbstractTest;
import net.sf.katta.util.ThrottledInputStream.ThrottleSemaphore;

import org.junit.Before;
import org.junit.Test;

public class ShardManagerTest extends AbstractTest {

  private File _testFile = new File("lib");

  @Before
  public void setUp() {
    // _managerFolder = _temporaryFolder.newFolder("managerFolder");
    assertTrue("test file" + _testFile + " does not exists", _testFile.exists());
  }

  @Test
  public void testThrotteling() throws Exception {
    String shardName = "shard";
    File managerFolder = _temporaryFolder.newFolder("managerFolder");

    // measure transfer rate with no throttle
    ShardManager shardManager = new ShardManager(managerFolder);
    long startTime = System.nanoTime();
    long fileLength = org.apache.hadoop.fs.FileUtil.getDU(_testFile);
    shardManager.installShard(shardName, _testFile.getAbsolutePath());
    double durationInSec = (System.nanoTime() - startTime) / 1e9;
    double bytesPerSec = fileLength / durationInSec;
    printResults(fileLength, durationInSec, bytesPerSec);

    // now do the same throttled to half speed
    shardManager.uninstallShard(shardName);
    shardManager = new ShardManager(managerFolder, new ThrottleSemaphore((long)(bytesPerSec / 3)));
    startTime = System.nanoTime();
    shardManager.installShard(shardName, _testFile.getAbsolutePath());
    durationInSec = (System.nanoTime() - startTime) / 1e9;
    double bytesPerSec2 = fileLength / durationInSec;
    printResults(fileLength, durationInSec, bytesPerSec2);
    assertThat((long)bytesPerSec2, almostEquals((long)(bytesPerSec / 3), (long) (.1 / 3.0 * bytesPerSec)));
  }

  private void printResults(long fileLength, double durationInSec, double bytesPerSec) {
    System.out.println("took " + durationInSec + " sec to install ~" + fileLength / 1024 / 1024 + " MB");
    System.out.println("rate " + bytesPerSec + " bytes/sec");
  }
}
