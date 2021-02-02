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

package org.thinkit.formatter.common;

/**
 * インデント処理を抽象化したインターフェースです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
public interface Indentable {

    /**
     * インデント数をインクリメントします。
     * <p>
     * この {@link Indentable#increment()}
     * メソッドは自分自身のインスタンスを返却するため、後続処理をメソッドチェーンの形式で行うことができます。
     *
     * @return 自分自身のインスタンス
     */
    public Indentable increment();

    /**
     * インデント数をデクリメントします。
     * <p>
     * この {@link Indentable#decrement()}
     * メソッドは自分自身のインスタンスを返却するため、後続処理をメソッドチェーンの形式で行うことができます。
     *
     * @return 自分自身のインスタンス
     */
    public Indentable decrement();

    /**
     * インデント数の状態を初期状態へリセットします。
     * <p>
     * この {@link Indentable#reset()}
     * メソッドは自分自身のインスタンスを返却するため、後続処理をメソッドチェーンの形式で行うことができます。
     *
     * @return 自分自身のインスタンス
     */
    public Indentable reset();

    /**
     * インデント数分の空白またはタブを返却します。
     *
     * @return インデント数分の {@code " "} または {@code "¥t"}
     */
    public String getIndent();

    /**
     * インデントファクターを返却します。
     *
     * @return インデントファクター
     */
    public int getIndentFactor();
}
