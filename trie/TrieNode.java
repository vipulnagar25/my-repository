package com.trie;

public class TrieNode {
	public TrieNode[] children;
	public boolean isWord;
	
	public TrieNode() {
		this.children = new TrieNode[26]; // storing english words - a -> z
		this.isWord = false;
	}
}
