/*
 * Copyright 2021 Kato Shinya.
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

package org.thinkit.formatter.common.helper;

import org.thinkit.common.base.precondition.Preconditions;
import org.thinkit.formatter.common.catalog.IndentType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * インデント種別に応じたインデントを取得する処理を定義したクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.2
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(staticName = "from")
public final class IndentHelper {

    /**
     * インデント種別
     */
    private final IndentType indentType;

    /**
     * {@link IndentHelper} クラスのインスタンス生成時に設定されたインデント種別に応じたインデントを文字列として返却します。
     * <p>
     * この {@link #getIndent()}
     * メソッドから返却される文字列は、インデント種別が半角スペースであれば半角スペース4つ、インデント種別がタブであればタブ1つになります。
     *
     * @return インデント種別に応じたインデント文字列
     */
    public String getIndent() {
        return switch (this.indentType) {
            case SPACE -> this.getIndentSpaces(4);
            case TAB -> this.getIndentTabs(1);
        };
    }

    /**
     * {@link IndentHelper} クラスのインスタンス生成時に設定されたインデント種別に応じたインデントを文字列として返却します。
     *
     * @param indent 任意のインデント数
     * @return インデント種別に応じたインデント文字列
     */
    public String getIndent(final int indent) {
        return switch (this.indentType) {
            case SPACE -> this.getIndentSpaces(indent);
            case TAB -> this.getIndentTabs(indent);
        };
    }

    /**
     * 引数として指定された個数分の半角空白を返却します。
     * <p>
     * このメソッドからは引数として指定された任意の個数分のインデント用文字列が返却されます。
     *
     * @param indent インデント用文字列を生成する際に使用する任意の空白数
     * @return 指定された空白数に対応したインデント用文字列
     * @see #getIndentSpaces()
     */
    private String getIndentSpaces(int indent) {

        Preconditions.requirePositive(indent);

        final StringBuilder indentSpaces = new StringBuilder(indent);
        final String space = IndentType.SPACE.getTag();

        for (int i = 0; i < indent; i++) {
            indentSpaces.append(space);
        }

        return indentSpaces.toString();
    }

    /**
     * 引数として指定された個数分のタブコードを返却します。
     * <p>
     * このメソッドからは引数として指定された任意の個数分のインデント用文字列が返却されます。
     *
     * @param indent インデント用文字列を生成する際に使用する任意のタブコード数
     * @return 指定されたタブコード数に対応したインデント用文字列
     * @see #getIndentTabs()
     */
    private String getIndentTabs(int indent) {
        Preconditions.requirePositive(indent);

        final StringBuilder indentTabs = new StringBuilder(indent);
        final String tabCode = IndentType.TAB.getTag();

        for (int i = 0; i < indent; i++) {
            indentTabs.append(tabCode);
        }

        return indentTabs.toString();
    }
}
