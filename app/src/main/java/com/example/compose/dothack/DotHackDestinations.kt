/*
 * Copyright 2022 The WakuWaku Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.compose.dothack

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.compose.dothack.ui.accounts.AccountsScreen
import com.example.compose.dothack.ui.accounts.SingleAccountScreen
import com.example.compose.dothack.ui.bills.BillsScreen
import com.example.compose.dothack.ui.overview.OverviewScreen

/**
 * Contract for information needed on every PackView navigation destination
 */
interface DotHackDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

/**
 * PackView app navigation destinations
 */
object Overview : DotHackDestination {
    override val icon = Icons.Filled.PieChart
    override val route = "overview"
    override val screen: @Composable () -> Unit = { OverviewScreen() }
}

object Accounts : DotHackDestination {
    override val icon = Icons.Filled.AttachMoney
    override val route = "accounts"
    override val screen: @Composable () -> Unit = { AccountsScreen() }
}

object Bills : DotHackDestination {
    override val icon = Icons.Filled.MoneyOff
    override val route = "bills"
    override val screen: @Composable () -> Unit = { BillsScreen() }
}

object SingleAccount : DotHackDestination {
    // Added for simplicity, this icon will not in fact be used, as SingleAccount isn't
    // part of the PackViewTabRow selection
    override val icon = Icons.Filled.Money
    override val route = "single_account"
    override val screen: @Composable () -> Unit = { SingleAccountScreen() }
    const val accountTypeArg = "account_type"
}

// Screens to be displayed in the top PackViewTabRow
val dothackTabRowScreens = listOf(Overview, Accounts, Bills)
