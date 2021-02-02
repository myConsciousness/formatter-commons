/*
 * Copyright 2020 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.formatter.common.catalog;

import org.thinkit.api.catalog.BiCatalog;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 整形処理を行う際の空白を管理するカタログです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@RequiredArgsConstructor
public enum Whitespace implements BiCatalog<Whitespace, String> {

    /**
     * 空白
     */
    SPACE(0, " "),

    /**
     * タブ
     */
    TAB(1, "\t"),

    /**
     * 復帰
     */
    RETURN(2, "\r"),
    /**
     * 改行
     */
    NEW_LINE(3, "\n"),

    /**
     * 改ページ
     */
    NEW_PAGE(4, "\f"),

    /**
     * 全角空白
     */
    FULL_WIDTH_SPACE(5, "　");

    /**
     * コード値
     */
    @Getter
    private final int code;

    /**
     * タグ
     */
    @Getter
    private final String tag;
}
