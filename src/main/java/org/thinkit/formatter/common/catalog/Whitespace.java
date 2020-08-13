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

import org.thinkit.common.catalog.Catalog;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 整形処理を行う際の空白を管理するカタログです。
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
@RequiredArgsConstructor
public enum Whitespace implements Catalog<Whitespace> {

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
    NEW_PAGE(4, "\f");

    /**
     * コード値
     */
    @Getter
    private final int code;

    /**
     * 空白
     */
    @Getter
    private final String whitespace;

    /**
     * {@link Whitespace} クラスに引数として渡された {@code token} 文字列が定義されているか判定します。
     *
     * @param token 判定対象のトークン
     * @return {@link Whitespace} クラスに引数として渡された {@code token} 文字列が定義されている場合は
     *         {@code true} 、それ以外は {@code false}
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static boolean contains(@NonNull String token) {

        for (Whitespace whitespace : Whitespace.values()) {
            if (whitespace.getWhitespace().equals(token)) {
                return true;
            }
        }

        return false;
    }
}