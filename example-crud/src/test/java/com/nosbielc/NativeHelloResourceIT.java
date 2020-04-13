package com.nosbielc;

import com.nosbielc.resource.HelloResourceTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeHelloResourceIT extends HelloResourceTest {

    // Execute the same tests but in native mode.
}