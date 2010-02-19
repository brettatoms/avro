/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.avro.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.io.BinaryDecoder;

/** 
 * Interface for Avro-supported compression codecs for data files.
 *
 * This is currently exclusively an internal-facing API.
 */
abstract class Codec {
  /** Name of the codec; written to the file's metadata. */
  abstract String getName();
  /** Compresses the input data and return the result as a ByteArrayOutputStream */
  abstract ByteArrayOutputStream compress(ByteArrayOutputStream data) throws IOException;
  /** Returns a decoder on the uncompressed data. */
  abstract BinaryDecoder decompress(byte[] compressedData, int offset, int length) throws IOException;
}
