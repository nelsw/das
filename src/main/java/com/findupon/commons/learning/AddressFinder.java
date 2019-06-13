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

package com.findupon.commons.learning;

import com.findupon.commons.building.AddressOperations;
import com.findupon.commons.entity.datasource.AssetType;
import com.findupon.commons.entity.learning.PossibleAssetType;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class AddressFinder implements AssetDeterminer {

	@Override
	public PossibleAssetType getPossibleAssetType(@NotNull Document document) {
		PossibleAssetType possibleAssetType = new PossibleAssetType();
		possibleAssetType.setAssetType(AssetType.AUTOMOBILE);

		if(AddressOperations.getAddress(document).isPresent()) {
			possibleAssetType.setGuess(true);
			possibleAssetType.setRelativeProbability(1D);
		} else {
			possibleAssetType.setGuess(false);
			possibleAssetType.setRelativeProbability(0D);
		}
		return possibleAssetType;
	}
}
