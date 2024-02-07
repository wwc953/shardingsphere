/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.mask.distsql.handler.query;

import org.apache.shardingsphere.distsql.handler.engine.query.rql.ShowRulesUsedStorageUnitRowBuilder;
import org.apache.shardingsphere.distsql.statement.rql.rule.database.ShowRulesUsedStorageUnitStatement;
import org.apache.shardingsphere.infra.merge.result.impl.local.LocalDataQueryResultRow;
import org.apache.shardingsphere.mask.rule.MaskRule;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Show mask rules used storage unit row builder.
 */
public final class ShowMaskRulesUsedStorageUnitRowBuilder implements ShowRulesUsedStorageUnitRowBuilder<MaskRule> {
    
    @Override
    public Collection<LocalDataQueryResultRow> getInUsedData(final ShowRulesUsedStorageUnitStatement sqlStatement, final MaskRule rule) {
        return rule.getConfiguration().getTables().stream().map(each -> new LocalDataQueryResultRow("mask", each.getName())).collect(Collectors.toList());
    }
    
    @Override
    public Class<MaskRule> getType() {
        return MaskRule.class;
    }
}