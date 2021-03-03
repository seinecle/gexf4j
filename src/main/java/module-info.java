/*
 * Copyright 2021 LEVALLOIS.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

module gexf4j {
    requires com.google.common;
    requires java.xml;
    requires commons.io;
    
    exports it.uniroma1.dis.wsngroup.gexf4j.core;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.data;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.dynamic;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.impl;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.utils;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.viz;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.impl.data;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.impl.dynamic;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.impl.viz;
    exports it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;
}
