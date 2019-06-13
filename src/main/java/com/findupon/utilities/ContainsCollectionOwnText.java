/*
 * Copyright 2015-2019 Connor Van Elswyk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.findupon.utilities;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Evaluator;

import java.util.Collection;

public class ContainsCollectionOwnText extends Evaluator {

    private Collection<String> searchTexts;

    public ContainsCollectionOwnText(Collection<String> searchTexts) {
        this.searchTexts = searchTexts;
    }

    @Override
    public boolean matches(Element root, Element element) {
        if(!element.hasText()) {
            return false;
        }
        String text = element.ownText();
        if(StringUtils.isEmpty(text)) {
            return false;
        }
        for(String searchText : searchTexts) {
            if(StringUtils.containsIgnoreCase(text, searchText)) {
                return true;
            }
        }
        return false;
    }

}