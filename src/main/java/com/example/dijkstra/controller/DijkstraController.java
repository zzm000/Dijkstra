/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dijkstra.controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class DijkstraController {

    @PostMapping("/dijkstra")
    public ResponseEntity<Map<String, Object>> getShortestPath(@RequestBody Map<String, Object> payload) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:5000/dijkstra";

        ResponseEntity<Map> response = restTemplate.postForEntity(url, payload, Map.class);

        return ResponseEntity.ok(response.getBody());
    }
}